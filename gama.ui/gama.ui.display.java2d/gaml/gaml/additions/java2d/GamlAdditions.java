package gaml.additions.java2d;

import gaml.core.architecture.finite_state_machine.*;
import gaml.core.extensions.multi_criteria.*;
import gaml.core.architecture.user.*;
import gama.core.runtime.exceptions.*;
import java.lang.*;
import gama.core.outputs.layers.*;
import gama.core.util.*;
import gama.core.extensions.messaging.*;
import gaml.core.operators.*;
import  gama.core.metamodel.shape.*;
import gama.core.metamodel.shape.*;
import gama.core.outputs.layers.charts.*;
import gaml.core.statements.test.*;
import gaml.core.compilation.*;
import gaml.core.skills.*;
import gama.core.metamodel.population.*;
import gama.core.util.tree.*;
import gama.core.util.matrix.*;
import gaml.core.variables.*;
import gama.core.kernel.root.*;
import gama.core.util.path.*;
import gama.core.kernel.experiment.*;
import java.util.*;
import gaml.core.statements.draw.*;
import gaml.core.descriptions.*;
import gama.core.util.graph.*;
import gaml.core.statements.*;
import gama.core.kernel.model.*;
import gama.core.outputs.*;
import gama.core.metamodel.topology.*;
import gaml.core.factories.*;
import gaml.core.species.*;
import gama.core.metamodel.agent.*;
import gama.core.util.file.*;
import gama.core.kernel.batch.*;
import gaml.core.types.*;
import gaml.core.architecture.reflex.*;
import gaml.core.architecture.weighted_tasks.*;
import gaml.core.expressions.*;
import gama.core.common.interfaces.*;
import gama.core.runtime.*;
import gama.core.kernel.simulation.*;
import gaml.core.operators.Random;
import gaml.core.operators.Maths;
import gaml.core.operators.Points;
import gaml.core.operators.Spatial.Properties;
import gaml.core.operators.System;
import static gaml.core.operators.Cast.*;
import static gaml.core.operators.Spatial.*;
import static gama.annotations.common.interfaces.IKeyword.*;
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })

public class GamlAdditions extends gaml.core.compilation.AbstractGamlAdditions {
	public void initialize() throws SecurityException, NoSuchMethodException {
	initializeDisplay();
}public void initializeDisplay()  {
_display("java2D",(a)->new gama.ui.display.java2d.Java2DDisplaySurface(a));
_display("2d",(a)->new gama.ui.display.java2d.Java2DDisplaySurface(a));
}
}