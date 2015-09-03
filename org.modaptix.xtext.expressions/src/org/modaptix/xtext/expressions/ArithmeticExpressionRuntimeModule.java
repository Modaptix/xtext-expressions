/*******************************************************************************
 * Copyright (c) 2015 Modaptix Limited.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Max Hacking - initial implementation
 *     
 *******************************************************************************/

package org.modaptix.xtext.expressions;

import org.eclipse.xtext.conversion.IValueConverterService;


/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class ArithmeticExpressionRuntimeModule extends org.modaptix.xtext.expressions.AbstractArithmeticExpressionRuntimeModule
{
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService()
	{
		return TerminalConverters.class;
	}
}
