/*
 * Copyright 2002-2020 the original author or authors.
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

/**
 * A callback interface for a decorator（装饰器的回调接口） to be applied to any {@link Runnable}
 * about to be executed.
 *
 * <p>Note that such a decorator is not necessarily（不是必要的） being applied to the
 * user-supplied {@code Runnable}/{@code Callable} but rather to the actual
 * execution callback (which may be a wrapper around the user-supplied task).
 *
 * <p>The primary use case is to set some execution context around the task's
 * invocation, or to provide some monitoring/statistics for task execution.
 * （主要用于设置任务调用的上下文信息，或者为任务提供监控和统计）
 *
 * <p><b>NOTE:</b> Exception handling in {@code TaskDecorator} implementations
 * may be limited. Specifically in case of a {@code Future}-based operation,
 * the exposed {@code Runnable} will be a wrapper which does not propagate
 * any exceptions from its {@code run} method.
 *
 * @author Juergen Hoeller
 * @since 4.3
 * @see TaskExecutor#execute(Runnable)
 * @see SimpleAsyncTaskExecutor#setTaskDecorator
 * @see org.springframework.core.task.support.TaskExecutorAdapter#setTaskDecorator
 */
@FunctionalInterface
public interface TaskDecorator { //任务的装饰器

	/**
	 * Decorate the given {@code Runnable}, returning a potentially（潜在地） wrapped
	 * {@code Runnable} for actual execution, internally delegating（授权、委派） to the
	 * original {@link Runnable#run()} implementation.
	 * @param runnable the original {@code Runnable}
	 * @return the decorated {@code Runnable}
	 */
	Runnable decorate(Runnable runnable); //对给定的线程进行装饰，decorate: 装饰

}
