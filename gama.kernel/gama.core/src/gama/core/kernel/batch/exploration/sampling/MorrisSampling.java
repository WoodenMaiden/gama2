/*******************************************************************************************************
 *
 * MorrisSampling.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.kernel.batch.exploration.sampling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import gama.core.kernel.experiment.ParametersSet;
import gama.core.kernel.experiment.IParameter.Batch;
import gama.core.runtime.IScope;
import gama.core.runtime.exceptions.GamaRuntimeException;

/**
 *
 * @author tomroy
 *
 */

/**
 *
 * This class make a Morris Sampling for a Morris analysis
 *
 */
public class MorrisSampling extends SamplingUtils {

	public static class Trajectory {
		List<Double> seed;
		List<Integer> variableOrder;
		List<Double> deltas;
		List<List<Double>> points;

		/**
		 * Build a trajectory.
		 *
		 * @param seed
		 *            : First value for each parameters
		 * @param variableOrder
		 *            : List of indices indicating the visit order of each parameters
		 * @param deltas
		 *            : the increase/decrease value for each parameters
		 * @param points
		 *            : Points that the trajectory visit.
		 */
		public Trajectory(final List<Double> seed, final List<Integer> variableOrder, final List<Double> deltas,
				final List<List<Double>> points) {
			this.seed = seed;
			this.variableOrder = variableOrder;
			this.deltas = deltas;
			this.points = points;
		}
	}

	/**
	 * For a given number of parameters k, a number of levels p, generation an initial seed for this parameters
	 */
	private static List<Double> seed(final int k, final int p, final Random rng) {
		List<Double> seed = new ArrayList<>();
		double delta = 1 / (2 * ((double) p - 1));
		IntStream.range(0, k).forEach(i -> seed.add((rng.nextInt(p * 2 - 2) + 1) * delta));
		return seed;
	}

	/**
	 * Build a trajectory (2nd function)
	 */
	private static List<Object> TrajectoryBuilder(final double delta, final List<Integer> order, final List<Integer> direction,
			final List<Double> seed, final List<List<Double>> accPoints, final List<Double> accdelta, final int index) {
		if (order.isEmpty()) {
			List<Object> trajectory = new ArrayList<>();
			trajectory.add(accPoints);
			trajectory.add(accdelta);
			return trajectory;
		}
		int idx = order.get(0);
		double deltaOriented = delta * direction.get(0);
		double valTemp = seed.get(idx) + deltaOriented;
		List<Double> new_seed = new ArrayList<>(seed);
		new_seed.set(idx, valTemp);
		order.remove(0);
		direction.remove(0);
		accPoints.add(new_seed);
		accdelta.add(deltaOriented);
		return TrajectoryBuilder(delta, order, direction, new_seed, accPoints, accdelta, index + 1);
	}

	/**
	 * Build a trajectory (1st function)
	 */
	private static List<Object> TrajectoryBuilder(final double delta, final List<Integer> order, final List<Integer> direction,
			final List<Double> seed) {
		List<List<Double>> accPoints = new ArrayList<>();
		List<Double> accDelta = new ArrayList<>();
		if (order.isEmpty()) {
			// This is probably never used
			List<Object> trajectory = new ArrayList<>();
			trajectory.add(accPoints);
			trajectory.add(accDelta);
			return trajectory;
		}
		int idx = order.get(0);
		double deltaOriented = delta * direction.get(0);
		double valTemp = seed.get(idx) + deltaOriented;
		List<Double> new_seed = new ArrayList<>(seed);
		new_seed.set(idx, valTemp);
		order.remove(0);
		direction.remove(0);
		accPoints.add(new_seed);
		accDelta.add(deltaOriented);
		return TrajectoryBuilder(delta, order, direction, new_seed, accPoints, accDelta, 1);

	}

	/**
	 * Create data for making trajectory k: Number of variable p: Number of levels (Should be even) return: new
	 * Trajectory composed of several points to visit
	 */
	@SuppressWarnings("unchecked")
	private static Trajectory makeTrajectory(final int k, final int p, final Random rng) {
		double delta = 1 / (2 * ((double) p - 1));
		List<Double> seed = seed(k, p, rng);
		List<Integer> orderVariables = new ArrayList<>();
		IntStream.range(0, k).forEach(orderVariables::add);
		Collections.shuffle(orderVariables);
		List<Integer> directionVariables = new ArrayList<>();
		IntStream.range(0, k).forEach(s -> directionVariables.add(rng.nextInt(2) * 2 - 1));
		List<Integer> new_orderVariables = new ArrayList<>(orderVariables);
		List<Object> List_p_d = TrajectoryBuilder(delta, orderVariables, directionVariables, seed);
		List<List<Double>> points = (List<List<Double>>) List_p_d.get(0);
		List<Double> deltas = (List<Double>) List_p_d.get(1);
		return new Trajectory(seed, new_orderVariables, deltas, points);
	}

	/**
	 * Recursive function that add trajectories
	 */
	private static List<Trajectory> addTrajectories(final int k, final int p, final int r, final Random rng,
			final List<Trajectory> acc) {
		if (r == 0) return acc;
		acc.add(makeTrajectory(k, p, rng));
		return addTrajectories(k, p, r - 1, rng, acc);
	}

	/**
	 * Generates r independent trajectories for k variables sampled with p levels.
	 */
	private static List<Trajectory> MorrisTrajectories(final int k, final int p, final int r, final Random rng) {
		List<Trajectory> acc = new ArrayList<>();
		if (r == 0)
			// Probably never used
			return acc;
		acc.add(makeTrajectory(k, p, rng));
		return addTrajectories(k, p, r - 1, rng, acc);
	}

	/**
	 * Main method for Morris samples, give the samples with List<ParametersSet> and List<Map<String,Object>>
	 *
	 * @param nb_levels
	 *            the number of levels (Should be even, frequently 4)
	 * @param nb_sample
	 *            the number of sample for each parameter. Add the end, the number of simulation is nb_sample *
	 *            nb_parameters
	 * @param parameters
	 *            Parameters of the model. 
	 * @param scope
	 * @return samples for simulations. Size: nb_sample * inputs.size()
	 */
	public static List<Object> MakeMorrisSampling(final int nb_levels, final int nb_sample,
			final List<Batch> parameters, final IScope scope) {
		if (nb_levels % 2 != 0) throw GamaRuntimeException.error("The number of value should be even", scope);
		int nb_attributes = parameters.size();
		List<Trajectory> trajectories =
				MorrisTrajectories(nb_attributes, nb_levels, nb_sample, scope.getRandom().getGenerator());
		List<String> nameInputs = new ArrayList<>();
		for (int i = 0; i < parameters.size(); i++) { nameInputs.add(parameters.get(i).getName()); }
		List<Map<String, Double>> MorrisSamples = new ArrayList<>();
		trajectories.forEach(t -> {
			t.points.forEach(p -> {
				Map<String, Double> tmpMap = new LinkedHashMap<>();
				IntStream.range(0, nb_attributes).forEach(i -> { tmpMap.put(nameInputs.get(i), p.get(i)); });
				MorrisSamples.add(tmpMap);
			});

		});
		List<Object> result=new ArrayList<>();
		result.add(MorrisSamples);
		result.add(BuildParametersSetfromSample(scope, parameters, MorrisSamples));
		return result;
	}
	
	/**
	 * Same as above but only give the sampling with a list of parameter set
	 * @param nb_levels
	 * 				the number of levels (Should be even, frequently 4)
	 * @param nb_sample
	 *            the number of sample for each parameter. Add the end, the number of simulation is nb_sample *
	 *            nb_parameters
	 * @param parameters
	 *            Parameters of the model. 
	 * @param scope
	 * @return
	 */
	public static List<ParametersSet> MakeMorrisSamplingOnly(final int nb_levels, final int nb_sample,
			final List<Batch> parameters, final IScope scope) {
		if (nb_levels % 2 != 0) throw GamaRuntimeException.error("The number of value should be even", scope);
		int nb_attributes = parameters.size();
		List<Trajectory> trajectories =
				MorrisTrajectories(nb_attributes, nb_levels, nb_sample, scope.getRandom().getGenerator());
		List<String> nameInputs = new ArrayList<>();
		for (int i = 0; i < parameters.size(); i++) { nameInputs.add(parameters.get(i).getName()); }
		List<Map<String, Double>> MorrisSamples = new ArrayList<>();
		trajectories.forEach(t -> {
			t.points.forEach(p -> {
				Map<String, Double> tmpMap = new LinkedHashMap<>();
				IntStream.range(0, nb_attributes).forEach(i -> { tmpMap.put(nameInputs.get(i), p.get(i)); });
				MorrisSamples.add(tmpMap);
			});
		});
		return BuildParametersSetfromSample(scope, parameters, MorrisSamples);
	}
}
