/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.test.context.junit4.orm.repository.hibernate;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.orm.domain.Person;
import org.springframework.test.context.junit4.orm.repository.PersonRepository;

/**
 * Hibernate implementation of the {@link PersonRepository} API.
 *
 * @author Sam Brannen
 * @since 3.0
 */
@Repository
public class HibernatePersonRepository implements PersonRepository { //Hibernate方式实现的仓库

	private final SessionFactory sessionFactory; //hibernate的会话管理工厂


	@Autowired
	public HibernatePersonRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Person save(Person person) {
		this.sessionFactory.getCurrentSession().save(person);
		return person;
	}

	@Override
	public Person findByName(String name) {
		return (Person) this.sessionFactory.getCurrentSession().createQuery(
			"from Person person where person.name = :name").setParameter("name", name).getSingleResult();
	}

}
