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
package com.jdon.sample.test.domain.simplecase.repository;

import com.jdon.annotation.Component;
import com.jdon.annotation.Introduce;
import com.jdon.annotation.model.OnEvent;
import com.jdon.annotation.pointcut.Around;
import com.jdon.sample.test.domain.simplecase.MyModel;
import com.jdon.sample.test.domain.simplecase.MyModelCreatedEvent;

@Component("mymrepository")
@Introduce("modelCache")
public class RepositoryImp implements MyModelRepository {

	@Around
	public MyModel getModel(Long key) {
		MyModel mym = new MyModel();
		mym.setId(key);
		return mym;
	}

	@OnEvent("saveMyModel")
	public void save(MyModelCreatedEvent myModelCreatedEvent) {
		System.out.print("\n No.2 @OnEvent:" + this.getClass().getName());

	}

}
