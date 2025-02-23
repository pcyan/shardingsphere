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

package org.apache.shardingsphere.proxy.frontend.command.executor;

import org.apache.shardingsphere.db.protocol.packet.DatabasePacket;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Command executor.
 */
public interface CommandExecutor {
    
    /**
     * Execute command.
     *
     * @return database packets to be sent
     * @throws SQLException SQL exception
     */
    Collection<DatabasePacket> execute() throws SQLException;
    
    /**
     * Close command executor.
     *
     * @throws SQLException SQL exception
     */
    default void close() throws SQLException {
    }
}
