/*
The MIT License (MIT)

Copyright (c) 2014 jsonrpc4j

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package com.yzmy.jsonrpc4j.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzmy.jsonrpc4j.JsonRpcServer;
import org.springframework.web.HttpRequestHandler;

/**
 * {@link HttpRequestHandler} that exports services using Json
 * according to the JSON-RPC proposal specified at:
 * <a href="http://groups.google.com/group/json-rpc">
 * http://groups.google.com/group/json-rpc</a>.
 *
 */
public class JsonServiceExporter
	extends AbstractJsonServiceExporter
	implements HttpRequestHandler {

	private JsonRpcServer jsonRpcServer;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void exportService() {
		jsonRpcServer = getJsonRpcServer();
	}

	/**
	 * {@inheritDoc}
	 */
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,
		IOException {
		jsonRpcServer.handle(request, response);
		response.getOutputStream().flush();
	}

}
