package org.modaptix.xtext.expressions.ui;

import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

public class ArithmeticExpressionAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper
{
	@Override
	protected String calculateId(String tokenName, int tokenType)
	{
		if (tokenName.equals("RULE_INT"))
		{
			return ArithmeticExpressionHighlightingConfiguration.INT_ID;
		}
		else if (tokenName.equals("RULE_HEX"))
		{
			return ArithmeticExpressionHighlightingConfiguration.HEX_ID;
		}
		else if (tokenName.equals("RULE_BINARY"))
		{
			return ArithmeticExpressionHighlightingConfiguration.BINARY_ID;
		}
		else if (tokenName.equals("RULE_FLOAT"))
		{
			return ArithmeticExpressionHighlightingConfiguration.FLOAT_ID;
		}
		
		return ArithmeticExpressionHighlightingConfiguration.DEFAULT_ID;
	}
}
