/*
 * =============================================================================
 * 
 *   Copyright (c) 2011, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.processor.attr;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Tag;
import org.thymeleaf.processor.IAttributeNameProcessorMatcher;
import org.thymeleaf.processor.ProcessorResult;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public abstract class AbstractConditionalVisibilityAttrProcessor 
        extends AbstractAttrProcessor {

    
    
    
    
    
    public AbstractConditionalVisibilityAttrProcessor(final String attributeName) {
        super(attributeName);
    }
    
    
    public AbstractConditionalVisibilityAttrProcessor(final IAttributeNameProcessorMatcher matcher) {
        super(matcher);
    }

    
    
    
    
    @Override
    public final ProcessorResult processAttribute(final Arguments arguments, final Tag tag, final String attributeName) {
        
        final boolean visible = 
            isVisible(arguments, tag, attributeName);
        
        if (!visible) {
            tag.clearChildren();
            tag.getParent().removeChild(tag);
            return ProcessorResult.OK;
        }
        
        tag.removeAttribute(attributeName);
        return ProcessorResult.OK;
        
    }


    
    
    protected abstract boolean isVisible(
            final Arguments arguments, final Tag tag, final String attributeName);


    
}
