/*******************************************************************************************************
 *
 * GamlParser.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.parser.antlr;

import com.google.inject.Inject;
import gaml.compiler.parser.antlr.internal.InternalGamlParser;
import gaml.compiler.services.GamlGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class GamlParser extends AbstractAntlrParser {

	@Inject
	private GamlGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalGamlParser createParser(XtextTokenStream stream) {
		return new InternalGamlParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Entry";
	}

	public GamlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(GamlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
