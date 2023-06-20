/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.impl.api.parallel;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.neo4j.common.DependencyResolver;
import org.neo4j.dbms.systemgraph.TopologyGraphDbmsModel;
import org.neo4j.graphdb.QueryExecutionException;
import org.neo4j.graphdb.ResultTransformer;
import org.neo4j.graphdb.Transaction;
import org.neo4j.internal.kernel.api.connectioninfo.ClientConnectionInfo;
import org.neo4j.internal.kernel.api.security.LoginContext;
import org.neo4j.io.layout.DatabaseLayout;
import org.neo4j.kernel.api.KernelTransaction;
import org.neo4j.kernel.api.exceptions.Status;
import org.neo4j.kernel.database.NamedDatabaseId;
import org.neo4j.kernel.impl.coreapi.InternalTransaction;
import org.neo4j.kernel.impl.coreapi.TransactionExceptionMapper;
import org.neo4j.kernel.impl.factory.DbmsInfo;
import org.neo4j.kernel.internal.GraphDatabaseAPI;

public class ExecutionContextGraphDatabaseAPI implements GraphDatabaseAPI {

    @Override
    public boolean isAvailable() {
        throw failure("isAvailable");
    }

    @Override
    public boolean isAvailable(long timeoutMillis) {
        throw failure("isAvailable");
    }

    @Override
    public Transaction beginTx() {
        throw failure("beginTx");
    }

    @Override
    public Transaction beginTx(long timeout, TimeUnit unit) {
        throw failure("beginTx");
    }

    @Override
    public void executeTransactionally(String query) throws QueryExecutionException {
        throw failure("executeTransactionally");
    }

    @Override
    public void executeTransactionally(String query, Map<String, Object> parameters) throws QueryExecutionException {
        throw failure("executeTransactionally");
    }

    @Override
    public <T> T executeTransactionally(
            String query, Map<String, Object> parameters, ResultTransformer<T> resultTransformer)
            throws QueryExecutionException {
        throw failure("executeTransactionally");
    }

    @Override
    public <T> T executeTransactionally(
            String query, Map<String, Object> parameters, ResultTransformer<T> resultTransformer, Duration timeout)
            throws QueryExecutionException {
        throw failure("executeTransactionally");
    }

    @Override
    public String databaseName() {
        throw failure("databaseName");
    }

    @Override
    public DependencyResolver getDependencyResolver() {
        throw failure("getDependencyResolver");
    }

    @Override
    public DatabaseLayout databaseLayout() {
        throw failure("databaseLayout");
    }

    @Override
    public NamedDatabaseId databaseId() {
        throw failure("databaseId");
    }

    @Override
    public DbmsInfo dbmsInfo() {
        throw failure("dbmsInfo");
    }

    @Override
    public TopologyGraphDbmsModel.HostedOnMode mode() {
        throw failure("mode");
    }

    @Override
    public InternalTransaction beginTransaction(KernelTransaction.Type type, LoginContext loginContext) {
        throw failure("beginTransaction");
    }

    @Override
    public InternalTransaction beginTransaction(
            KernelTransaction.Type type, LoginContext loginContext, ClientConnectionInfo clientInfo) {
        throw failure("beginTransaction");
    }

    @Override
    public InternalTransaction beginTransaction(
            KernelTransaction.Type type,
            LoginContext loginContext,
            ClientConnectionInfo clientInfo,
            long timeout,
            TimeUnit unit) {
        throw failure("beginTransaction");
    }

    @Override
    public InternalTransaction beginTransaction(
            KernelTransaction.Type type,
            LoginContext loginContext,
            ClientConnectionInfo clientInfo,
            long timeout,
            TimeUnit unit,
            Consumer<Status> terminationCallback,
            TransactionExceptionMapper transactionExceptionMapper) {
        throw failure("beginTransaction");
    }

    private UnsupportedOperationException failure(String op) {
        throw new UnsupportedOperationException(
                op + " is not allowed from parallel runtime, please remove 'runtime=parallel' and try again.");
    }
}
