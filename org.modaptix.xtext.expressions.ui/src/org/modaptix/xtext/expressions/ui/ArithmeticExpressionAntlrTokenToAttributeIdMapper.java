package org.modaptix.xtext.expressions.ui;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

public class ArithmeticExpressionAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper
{
	@Override
	protected String calculateId(String tokenName, int tokenType)
	{
		String temp = super.calculateId(tokenName, tokenType);
		if (temp != ArithmeticExpressionHighlightingConfiguration.DEFAULT_ID &&
			temp != ArithmeticExpressionHighlightingConfiguration.NUMBER_ID)
			return temp;

		
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
