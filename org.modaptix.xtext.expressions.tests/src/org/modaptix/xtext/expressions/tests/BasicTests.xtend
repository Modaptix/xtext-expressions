package org.modaptix.xtext.expressions.tests

import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.modaptix.xtext.expressions.arithmeticExpression.IntegerExpression
import org.modaptix.xtext.expressions.ArithmeticExpressionInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import com.google.inject.Inject
import org.junit.Test

import static org.junit.Assert.*

@InjectWith(ArithmeticExpressionInjectorProvider)
@RunWith(XtextRunner)
class BasicTests
{
	@Inject ParseHelper<IntegerExpression> parser

	@Test
	def void parseBasicIntegerExpression()
	{
		val expression = parser.parse("0")
		assertEquals(expression.value, 0)
	}

	@Test
	def void parseBasicNumbers()
	{
		val expression = parser.parse("150")
		assertEquals(150, expression.value)
	}

	@Test
	def void parseNegativeNumbers()
	{
		val expression = parser.parse("-150")
		assertEquals(-150, expression.value)
	}

	@Test
	def void parseHexNumbers()
	{
		val expression = parser.parse("0xFE")
		assertEquals(254, expression.value)
	}

	@Test
	def void parseBinaryNumbers()
	{
		val expression = parser.parse("10101010b")
		assertEquals(170, expression.value)
	}

	@Test
	def void parseBasicIntegerAddition()
	{
		val expression = parser.parse("1+2")
		assertEquals(3, expression.value)
	}

	@Test
	def void parseBasicIntegerSubtraction()
	{
		val expression = parser.parse("1-2")
		assertEquals(-1, expression.value)
	}

	@Test
	def void parseBasicIntegerMultiplication()
	{
		val expression = parser.parse("5*2")
		assertEquals(10, expression.value)
	}

	@Test
	def void parseBasicIntegerDivision()
	{
		val expression = parser.parse("20/3")
		assertEquals(6, expression.value)
	}
	
	@Test
	def void parseBasicIntegerPower()
	{
		val expression = parser.parse("7**5")
		assertEquals(16807, expression.value)
	}

	@Test
	def void parseBasicIntegerModulo()
	{
		val expression = parser.parse("20%3")
		assertEquals(2, expression.value)
	}

	@Test
	def void parseBasicIntegerASL()
	{
		val expression = parser.parse("1<<4")
		assertEquals(16, expression.value)
	}

	@Test
	def void parseBasicIntegerASR()
	{
		val expression = parser.parse("10000101b>>2")
		assertEquals(33, expression.value)
	}

	@Test
	def void parseBasicIntegerBitwiseOr()
	{
		val expression = parser.parse("170|85")
		assertEquals(255, expression.value)
	}

	@Test
	def void parseBasicIntegerBitwiseAnd()
	{
		val expression = parser.parse("171&85")
		assertEquals(1, expression.value)
	}
	
	@Test
	def void parseBasicIntegerBitwiseXor()
	{
		val expression = parser.parse("255^171")
		assertEquals(84, expression.value)
	}

	@Test
	def void parseBasicCompound()
	{
		val expression = parser.parse("1+2+3+4+5")
		assertEquals(15, expression.value)
	}

	@Test
	def void parsePrecidenceCompound()
	{
		val expression = parser.parse("2+5*8+7")
		assertEquals(49, expression.value)
	}

	@Test
	def void parseBracketedCompound()
	{
		val expression = parser.parse("(2+5)*(8+7)")
		assertEquals(105, expression.value)
	}
}
