/*
 * Copyright 2014 Harald Wellmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.web.undertow.service;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.service.http.HttpContext;



public class DefaultHttpContext implements HttpContext {
    
    
    private Bundle bundle;

    public DefaultHttpContext(Bundle bundle) {
        this.bundle = bundle;
    }
    
    @Override
    public boolean handleSecurity(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        return true;
    }

    @Override
    public URL getResource(String name) {
        String path = name.startsWith("/") ? name.substring(1) : name;
        return bundle.getResource(path);
    }

    @Override
    public String getMimeType(String name) {
        return null;
    }
}
