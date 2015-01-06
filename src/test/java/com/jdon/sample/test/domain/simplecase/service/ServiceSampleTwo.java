/*
 * Copyright 2003-2009 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.jdon.sample.test.domain.simplecase.service;

import com.jdon.annotation.Service;
import com.jdon.sample.test.domain.simplecase.MyModel;
import com.jdon.sample.test.domain.simplecase.repository.MyModelRepository;

@Service("serviceSampleTwo")
public class ServiceSampleTwo implements IServiceSampleTwo {

	private MyModelRepository repository;

	public ServiceSampleTwo(MyModelRepository repository) {
		super();
		this.repository = repository;
	}

	public Object eventPointEntry() {
		MyModel myModel = repository.getModel(new Long(100));
		MyModel myModel2 = repository.getModel(new Long(100));
		return myModel.sayHelloSynchronous() + " and " + myModel2.getName();

	}

	public void onEventTest() {
		MyModel myModel = repository.getModel(new Long(100));
		myModel.setName("new name");
		myModel.save();
	}
}
