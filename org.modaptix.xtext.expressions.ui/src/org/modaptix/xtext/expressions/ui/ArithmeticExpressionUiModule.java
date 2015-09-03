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

package org.modaptix.xtext.expressions.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class ArithmeticExpressionUiModule extends org.modaptix.xtext.expressions.ui.AbstractArithmeticExpressionUiModule
{
	public ArithmeticExpressionUiModule(AbstractUIPlugin plugin)
	{
		super(plugin);
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration()
	{
		return ArithmeticExpressionHighlightingConfiguration.class;
	}
	
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper()
	{
		return ArithmeticExpressionAntlrTokenToAttributeIdMapper.class ;
	}
}
