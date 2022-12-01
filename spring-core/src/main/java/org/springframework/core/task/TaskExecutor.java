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

package org.springframework.core.task;

import java.util.concurrent.Executor;

/**
 * Simple task executor interface that abstracts the execution
 * of a {@link Runnable}.
 *
 * <p>Implementations can use all sorts of different execution strategies（策略）,
 * such as: synchronous, asynchronous（支持同步、异步）, using a thread pool, and more.
 *
 * <p>Equivalent（等同的、等效的） to JDK 1.5's {@link java.util.concurrent.Executor}
 * interface; extending（扩展） it now in Spring 3.0, so that clients may declare
 * a dependency on an Executor and receive any TaskExecutor implementation.
 * This interface remains separate from the standard Executor interface
 * mainly for backwards compatibility with JDK 1.4 in Spring 2.x.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see java.util.concurrent.Executor
 */
@FunctionalInterface
public interface TaskExecutor extends Executor { //任务线程池

	/**
	 * Execute the given {@code task}.
	 * <p>The call might return immediately if the implementation uses
	 * an asynchronous execution strategy, or might block in the case
	 * of synchronous execution.
	 * @param task the {@code Runnable} to execute (never {@code null})
	 * @throws TaskRejectedException if the given task was not accepted
	 */
	@Override
	void execute(Runnable task); //执行给定的任务

}
