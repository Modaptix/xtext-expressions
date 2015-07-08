package org.modaptix.xtext.expressions;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;

public class TerminalConverters extends AbstractDeclarativeValueConverterService
{
	private Grammar grammar;
 	
	@Inject
	public void setGrammar(IGrammarAccess grammarAccess)
	{
		this.grammar = grammarAccess.getGrammar();
	}

	protected Grammar getGrammar()
	{
		return grammar;
	}

	private static final String[] VALID_HEX_PREFIXES = { "0x", "0X", "$" };

	private String removeValidHexPrefix(final String string)
	{
		for (String prefix : VALID_HEX_PREFIXES)
		{
			if (string.startsWith(prefix))
			{
				return string.substring(prefix.length());
			}
		}
		return null;
	}
	
	@ValueConverter(rule = "HEX")
	public IValueConverter<Long> HEX()
	{
		return new IValueConverter<Long>()
		{
			
			@Override
			public String toString(Long value) throws ValueConverterException
			{
				try
				{
					return "0x" + Long.toHexString(value);
				}
				catch (Exception e)
				{
					throw new ValueConverterException("Unable to convert Long to hex", null, e);
				}
			}
			
			@Override
			public Long toValue(String string, INode node) throws ValueConverterException
			{
				if (string == null)
					throw new ValueConverterException("Unable to convert null (hexadecimal) string to Long", node, null);
				if (string.isEmpty())
					throw new ValueConverterException("Unable to convert empty (hexadecimal) string to Long", node, null);
				
				String tmp = removeValidHexPrefix(string);
				
				if (tmp == null)
					throw new ValueConverterException("Unable to convert hexadecimal string \"" + string + "\" to Long", node, null);
				
				try
				{
					return Long.valueOf(tmp, 16);
				}
				catch (NumberFormatException e)
				{
					throw new ValueConverterException("Unable to convert hexadecimal string \"" + string + "\" to Long", node, e);
				}
			}
		};
	}
	
	private static final String[] VALID_BINARY_SUFFIXES = { "0x", "0X", "$" };

	private String removeValidBinarySuffix(final String string)
	{
		for (String prefix : VALID_BINARY_SUFFIXES)
		{
			if (string.endsWith(prefix))
			{
				return string.substring(0, prefix.length());
			}
		}
		return null;
	}
	
	@ValueConverter(rule = "BINARY")
	public IValueConverter<Long> BINARY()
	{
		return new IValueConverter<Long>()
		{
			
			@Override
			public String toString(Long value) throws ValueConverterException
			{
				try
				{
					return Long.toBinaryString(value) + "b";
				}
				catch (Exception e)
				{
					throw new ValueConverterException("Unable to convert Long to binary", null, e);
				}
			}
			
			@Override
			public Long toValue(String string, INode node) throws ValueConverterException
			{
				if (string == null)
					throw new ValueConverterException("Unable to convert null (binary) string to Long", node, null);
				if (string.isEmpty())
					throw new ValueConverterException("Unable to convert empty (binary) string to Long", node, null);
				
				String tmp = removeValidBinarySuffix(string);
				
				if (tmp == null)
					throw new ValueConverterException("Unable to convert binary string \"" + string + "\" to Long", node, null);
				
				try
				{
					return Long.valueOf(tmp, 2);
				}
				catch (NumberFormatException e)
				{
					throw new ValueConverterException("Unable to convert binary string \"" + string + "\" to Long", node, e);
				}
			}
		};
	}
}
