package org.modaptix.xtext.expressions.ui;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.*;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class ArithmeticExpressionHighlightingConfiguration extends DefaultHighlightingConfiguration
{
	// Provide ID strings for the highlighting calculator
	public static final String BINARY_ID = "binary";
	public static final String INT_ID = "int";
	public static final String HEX_ID = "hex";
	public static final String FLOAT_ID = "float";
		
	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor)
	{
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default text", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comments", commentTextStyle());
		acceptor.acceptDefaultHighlighting(INVALID_TOKEN_ID, "Invalid token", invalidTokenTextStyle());
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keywordTextStyle());
		//acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle());
		acceptor.acceptDefaultHighlighting(PUNCTUATION_ID, "Punctuation", punctuationTextStyle());
		acceptor.acceptDefaultHighlighting(STRING_ID, "Text String", stringTextStyle());
		
		acceptor.acceptDefaultHighlighting(BINARY_ID, "Binary number", binaryNumberTextStyle());
		acceptor.acceptDefaultHighlighting(INT_ID, "Integer number", integerNumberTextStyle());
		acceptor.acceptDefaultHighlighting(HEX_ID, "Hexadecimal number", hexadecimalNumberTextStyle());
		acceptor.acceptDefaultHighlighting(FLOAT_ID, "Floating point decimal number", floatingPointNumberTextStyle());
	}

	protected TextStyle binaryNumberTextStyle()
	{
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(250, 0, 0));
		return textStyle;
	}

	protected TextStyle integerNumberTextStyle()
	{
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 130, 0));
		return textStyle;
	}

	protected TextStyle hexadecimalNumberTextStyle()
	{
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 255));
		return textStyle;
	}

	protected TextStyle floatingPointNumberTextStyle()
	{
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 130, 175));
		return textStyle;
	}
	protected TextStyle invalidTokenTextStyle()
	{
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setBackgroundColor(new RGB(255, 0, 0));
		return textStyle;
	}
}
