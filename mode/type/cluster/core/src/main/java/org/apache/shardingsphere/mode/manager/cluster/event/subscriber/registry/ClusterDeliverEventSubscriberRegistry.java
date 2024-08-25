/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.mode.manager.cluster.event.subscriber.registry;

import org.apache.shardingsphere.infra.util.eventbus.EventBusContext;
import org.apache.shardingsphere.infra.util.eventbus.EventSubscriber;
import org.apache.shardingsphere.mode.event.subsciber.EventSubscriberRegistry;
import org.apache.shardingsphere.mode.manager.ContextManager;
import org.apache.shardingsphere.mode.manager.cluster.event.subscriber.deliver.DeliverQualifiedDataSourceSubscriber;
import org.apache.shardingsphere.mode.repository.cluster.ClusterPersistRepository;

import java.util.Collection;
import java.util.Collections;

/**
 * Cluster deliver event subscriber registry.
 */
public final class ClusterDeliverEventSubscriberRegistry implements EventSubscriberRegistry {
    
    private final EventBusContext eventBusContext;
    
    private final Collection<EventSubscriber> subscribers;
    
    public ClusterDeliverEventSubscriberRegistry(final ContextManager contextManager) {
        eventBusContext = contextManager.getComputeNodeInstanceContext().getEventBusContext();
        subscribers = Collections.singleton(new DeliverQualifiedDataSourceSubscriber((ClusterPersistRepository) contextManager.getPersistServiceFacade().getRepository()));
    }
    
    /**
     * Register subscribers.
     */
    public void register() {
        subscribers.forEach(eventBusContext::register);
    }
}
