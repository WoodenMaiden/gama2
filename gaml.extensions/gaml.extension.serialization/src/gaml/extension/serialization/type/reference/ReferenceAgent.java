/*******************************************************************************************************
 *
 * ReferenceAgent.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.type.reference;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Geometry;

import gama.annotations.common.interfaces.BiConsumerWithPruning;
import gama.core.common.geometry.Envelope3D;
import gama.core.kernel.model.IModel;
import gama.core.kernel.simulation.SimulationAgent;
import gama.core.metamodel.agent.IAgent;
import gama.core.metamodel.agent.IMacroAgent;
import gama.core.metamodel.agent.SavedAgent;
import gama.core.metamodel.population.IPopulation;
import gama.core.metamodel.shape.GamaPoint;
import gama.core.metamodel.shape.GamaShape;
import gama.core.metamodel.shape.IShape;
import gama.core.metamodel.topology.ITopology;
import gama.core.runtime.IScope;
import gama.core.runtime.exceptions.GamaRuntimeException;
import gama.core.util.IList;
import gama.core.util.IMap;
import gama.core.util.IReference;
import gaml.core.species.ISpecies;
import gaml.core.types.IType;

/**
 * The Class ReferenceAgent.
 */
public class ReferenceAgent implements IReference, IAgent {

	/** The agt attr. */
	ArrayList<AgentAttribute> agtAttr;

	/** The attribute value. */
	ReferenceToAgent attributeValue;

	/**
	 * Instantiates a new reference agent.
	 *
	 * @param _agt
	 *            the agt
	 * @param agtAttrName
	 *            the agt attr name
	 * @param agtAttrValue
	 *            the agt attr value
	 */
	public ReferenceAgent(final IAgent _agt, final String agtAttrName, final IAgent agtAttrValue) {
		// super(null,-1);
		agtAttr = new ArrayList<>();

		if (_agt != null && agtAttrName != null) { agtAttr.add(new AgentAttribute(_agt, agtAttrName)); }
		attributeValue = new ReferenceToAgent(agtAttrValue);
	}

	/**
	 * Instantiates a new reference agent.
	 *
	 * @param refAgt
	 *            the ref agt
	 * @param attrName
	 *            the attr name
	 * @param refAttrValue
	 *            the ref attr value
	 */
	public ReferenceAgent(final IAgent refAgt, final String attrName, final ReferenceToAgent refAttrValue) {
		// super(null,-1);

		agtAttr = new ArrayList<>();
		if (refAgt != null && attrName != null) { agtAttr.add(new AgentAttribute(refAgt, attrName)); }
		attributeValue = refAttrValue;
	}

	/**
	 * Gets the attribute value.
	 *
	 * @return the attribute value
	 */
	public ReferenceToAgent getAttributeValue() { return attributeValue; }

	/**
	 * Construct referenced object.
	 *
	 * @param sim
	 *            the sim
	 * @return the object
	 */
	@Override
	public Object constructReferencedObject(final SimulationAgent sim) {
		return getAttributeValue().getReferencedAgent(sim);
	}

	/**
	 * Gets the agent attributes.
	 *
	 * @return the agent attributes
	 */
	@Override
	public ArrayList<AgentAttribute> getAgentAttributes() { return agtAttr; }

	@Override
	public boolean equals(final Object o) {
		if (o == this) return true;
		return false;
	}

	/**
	 * Gets the referenced agent.
	 *
	 * @param sim
	 *            the sim
	 * @return the referenced agent
	 */
	public IAgent getReferencedAgent(final SimulationAgent sim) {
		return attributeValue.getReferencedAgent(sim);
	}

	@Override
	public int hashCode() {
		return System.identityHashCode(this);
	}

	/**
	 * Copy.
	 *
	 * @param scope
	 *            the scope
	 * @return the i shape
	 */
	@Override
	public IShape copy(final IScope scope) {

		return null;
	}

	/**
	 * Covers.
	 *
	 * @param g
	 *            the g
	 * @return true, if successful
	 */
	@Override
	public boolean covers(final IShape g) {

		return false;
	}

	/**
	 * Crosses.
	 *
	 * @param g
	 *            the g
	 * @return true, if successful
	 */
	@Override
	public boolean crosses(final IShape g) {

		return false;
	}

	/**
	 * Sets the geometrical type.
	 *
	 * @param t
	 *            the new geometrical type
	 */
	@Override
	public void setGeometricalType(final Type t) {}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {

	}

	/**
	 * Euclidian distance to.
	 *
	 * @param g
	 *            the g
	 * @return the double
	 */
	@Override
	public double euclidianDistanceTo(final GamaPoint g) {

		return 0;
	}

	/**
	 * Euclidian distance to.
	 *
	 * @param g
	 *            the g
	 * @return the double
	 */
	@Override
	public double euclidianDistanceTo(final IShape g) {

		return 0;
	}

	/**
	 * Gets the agent.
	 *
	 * @return the agent
	 */
	@Override
	public IAgent getAgent() {

		return null;
	}

	/**
	 * Gets the envelope.
	 *
	 * @return the envelope
	 */
	@Override
	public Envelope3D getEnvelope() {

		return null;
	}

	/**
	 * Gets the geometrical type.
	 *
	 * @return the geometrical type
	 */
	@Override
	public Type getGeometricalType() {

		return null;
	}

	/**
	 * Gets the inner geometry.
	 *
	 * @return the inner geometry
	 */
	@Override
	public Geometry getInnerGeometry() {

		return null;
	}

	/**
	 * Intersects.
	 *
	 * @param g
	 *            the g
	 * @return true, if successful
	 */
	@Override
	public boolean intersects(final IShape g) {

		return false;
	}

	/**
	 * Touches.
	 *
	 * @param g
	 *            the g
	 * @return true, if successful
	 */
	@Override
	public boolean touches(final IShape g) {

		return false;
	}

	/**
	 * Partially overlaps.
	 *
	 * @param g
	 *            the g
	 * @return true, if successful
	 */
	@Override
	public boolean partiallyOverlaps(final IShape g) {

		return false;
	}

	/**
	 * Checks if is line.
	 *
	 * @return true, if is line
	 */
	@Override
	public boolean isLine() {

		return false;
	}

	/**
	 * Checks if is point.
	 *
	 * @return true, if is point
	 */
	@Override
	public boolean isPoint() {

		return false;
	}

	/**
	 * Sets the agent.
	 *
	 * @param agent
	 *            the new agent
	 */
	@Override
	public void setAgent(final IAgent agent) {

	}

	/**
	 * Sets the inner geometry.
	 *
	 * @param intersection
	 *            the new inner geometry
	 */
	@Override
	public void setInnerGeometry(final Geometry intersection) {

	}

	/**
	 * Sets the depth.
	 *
	 * @param depth
	 *            the new depth
	 */
	@Override
	public void setDepth(final double depth) {

	}

	/**
	 * Gets the or create attributes.
	 *
	 * @return the or create attributes
	 */
	@Override
	public IMap<String, Object> getOrCreateAttributes() {

		return null;
	}

	/**
	 * Checks if is multiple.
	 *
	 * @return true, if is multiple
	 */
	@Override
	public boolean isMultiple() {

		return false;
	}

	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	@Override
	public Double getArea() {

		return null;
	}

	/**
	 * Gets the volume.
	 *
	 * @return the volume
	 */
	@Override
	public Double getVolume() {

		return null;
	}

	/**
	 * Gets the perimeter.
	 *
	 * @return the perimeter
	 */
	@Override
	public double getPerimeter() {

		return 0;
	}

	/**
	 * Gets the holes.
	 *
	 * @return the holes
	 */
	@Override
	public IList<GamaShape> getHoles() {

		return null;
	}

	/**
	 * Gets the centroid.
	 *
	 * @return the centroid
	 */
	@Override
	public GamaPoint getCentroid() {

		return null;
	}

	/**
	 * Gets the exterior ring.
	 *
	 * @param scope
	 *            the scope
	 * @return the exterior ring
	 */
	@Override
	public GamaShape getExteriorRing(final IScope scope) {

		return null;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	@Override
	public Double getWidth() {

		return null;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	@Override
	public Double getHeight() {

		return null;
	}

	/**
	 * Gets the depth.
	 *
	 * @return the depth
	 */
	@Override
	public Double getDepth() {

		return null;
	}

	/**
	 * Gets the geometric envelope.
	 *
	 * @return the geometric envelope
	 */
	@Override
	public GamaShape getGeometricEnvelope() {

		return null;
	}

	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	@Override
	public IList<GamaPoint> getPoints() { return null; }

	/**
	 * Gets the geometries.
	 *
	 * @return the geometries
	 */
	@Override
	public IList<? extends IShape> getGeometries() {

		return null;
	}

	/**
	 * String value.
	 *
	 * @param scope
	 *            the scope
	 * @return the string
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public String stringValue(final IScope scope) throws GamaRuntimeException {

		return null;
	}

	/**
	 * Serialize.
	 *
	 * @param includingBuiltIn
	 *            the including built in
	 * @return the string
	 */
	@Override
	public String serialize(final boolean includingBuiltIn) {

		return null;
	}

	/**
	 * Gets the gaml type.
	 *
	 * @return the gaml type
	 */
	@Override
	public IType<?> getGamlType() {

		return null;
	}
	//
	// @Override
	// public Map<String, Object> getAttributes() {
	//
	// return null;
	// }

	/**
	 * Gets the attribute.
	 *
	 * @param key
	 *            the key
	 * @return the attribute
	 */
	@Override
	public Object getAttribute(final String key) {

		return null;
	}

	/**
	 * Sets the attribute.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	@Override
	public void setAttribute(final String key, final Object value) {

	}

	/**
	 * Checks for attribute.
	 *
	 * @param key
	 *            the key
	 * @return true, if successful
	 */
	@Override
	public boolean hasAttribute(final String key) {

		return false;
	}

	/**
	 * Compare to.
	 *
	 * @param o
	 *            the o
	 * @return the int
	 */
	@Override
	public int compareTo(final IAgent o) {

		return 0;
	}

	/**
	 * Inits the.
	 *
	 * @param scope
	 *            the scope
	 * @return true, if successful
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public boolean init(final IScope scope) throws GamaRuntimeException {

		return false;
	}

	/**
	 * Step.
	 *
	 * @param scope
	 *            the scope
	 * @return true, if successful
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public boolean step(final IScope scope) throws GamaRuntimeException {

		return false;
	}

	/**
	 * Gets the.
	 *
	 * @param scope
	 *            the scope
	 * @param index
	 *            the index
	 * @return the object
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public Object get(final IScope scope, final String index) throws GamaRuntimeException {

		return null;
	}

	/**
	 * Gets the from indices list.
	 *
	 * @param scope
	 *            the scope
	 * @param indices
	 *            the indices
	 * @return the from indices list
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public Object getFromIndicesList(final IScope scope, final IList<String> indices) throws GamaRuntimeException {
		return null;
	}

	/**
	 * Gets the scope.
	 *
	 * @return the scope
	 */
	@Override
	public IScope getScope() { return null; }

	/**
	 * Gets the topology.
	 *
	 * @return the topology
	 */
	@Override
	public ITopology getTopology() { return null; }

	/**
	 * Sets the peers.
	 *
	 * @param peers
	 *            the new peers
	 */
	@Override
	public void setPeers(final IList<IAgent> peers) {

	}

	/**
	 * Gets the peers.
	 *
	 * @return the peers
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public IList<IAgent> getPeers() throws GamaRuntimeException { return null; }

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Override
	public String getName() { return null; }

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	@Override
	public void setName(final String name) {

	}

	/**
	 * Gets the location.
	 *
	 * @param scope
	 *            the scope
	 * @return the location
	 */
	@Override
	public GamaPoint getLocation(final IScope scope) {
		return null;
	}

	/**
	 * Sets the location.
	 *
	 * @param scope
	 *            the scope
	 * @param l
	 *            the l
	 * @return the gama point
	 */
	@Override
	public GamaPoint setLocation(final IScope scope, final GamaPoint l) {
		return l;
	}

	/**
	 * Gets the geometry.
	 *
	 * @param scope
	 *            the scope
	 * @return the geometry
	 */
	@Override
	public IShape getGeometry(final IScope scope) {
		return null;
	}

	/**
	 * Sets the geometry.
	 *
	 * @param scope
	 *            the scope
	 * @param newGeometry
	 *            the new geometry
	 */
	@Override
	public void setGeometry(final IScope scope, final IShape newGeometry) {}

	/**
	 * Dead.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean dead() {
		return false;
	}

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	@Override
	public IMacroAgent getHost() { return null; }

	/**
	 * Sets the host.
	 *
	 * @param macroAgent
	 *            the new host
	 */
	@Override
	public void setHost(final IMacroAgent macroAgent) {}

	/**
	 * Schedule.
	 *
	 * @param scope
	 *            the scope
	 */
	@Override
	public void schedule(final IScope scope) {}

	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	@Override
	public int getIndex() { return 0; }

	/**
	 * Gets the species name.
	 *
	 * @return the species name
	 */
	@Override
	public String getSpeciesName() { return null; }

	/**
	 * Gets the species.
	 *
	 * @return the species
	 */
	@Override
	public ISpecies getSpecies() { return null; }

	/**
	 * Gets the population.
	 *
	 * @return the population
	 */
	@Override
	public IPopulation<? extends IAgent> getPopulation() { return null; }

	/**
	 * Checks if is instance of.
	 *
	 * @param s
	 *            the s
	 * @param direct
	 *            the direct
	 * @return true, if is instance of
	 */
	@Override
	public boolean isInstanceOf(final ISpecies s, final boolean direct) {
		return false;
	}

	/**
	 * Gets the direct var value.
	 *
	 * @param scope
	 *            the scope
	 * @param s
	 *            the s
	 * @return the direct var value
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public Object getDirectVarValue(final IScope scope, final String s) throws GamaRuntimeException {
		return null;
	}

	/**
	 * Sets the direct var value.
	 *
	 * @param scope
	 *            the scope
	 * @param s
	 *            the s
	 * @param v
	 *            the v
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public void setDirectVarValue(final IScope scope, final String s, final Object v) throws GamaRuntimeException {

	}

	/**
	 * Gets the macro agents.
	 *
	 * @return the macro agents
	 */
	@Override
	public List<IAgent> getMacroAgents() { return null; }

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	@Override
	public IModel getModel() { return null; }

	/**
	 * Checks if is instance of.
	 *
	 * @param skill
	 *            the skill
	 * @param direct
	 *            the direct
	 * @return true, if is instance of
	 */
	@Override
	public boolean isInstanceOf(final String skill, final boolean direct) {
		return false;
	}

	/**
	 * Gets the population for.
	 *
	 * @param microSpecies
	 *            the micro species
	 * @return the population for
	 */
	@Override
	public IPopulation<? extends IAgent> getPopulationFor(final ISpecies microSpecies) {
		return null;
	}

	/**
	 * Gets the population for.
	 *
	 * @param speciesName
	 *            the species name
	 * @return the population for
	 */
	@Override
	public IPopulation<? extends IAgent> getPopulationFor(final String speciesName) {
		return null;
	}

	/**
	 * Update with.
	 *
	 * @param s
	 *            the s
	 * @param sa
	 *            the sa
	 */
	@Override
	public void updateWith(final IScope s, final SavedAgent sa) {

	}

	/**
	 * For each attribute.
	 *
	 * @param visitor
	 *            the visitor
	 */
	@Override
	public void forEachAttribute(final BiConsumerWithPruning<String, Object> visitor) {}
}
