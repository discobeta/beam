/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.sdk.metrics;

import com.google.auto.value.AutoValue;
import org.apache.beam.sdk.annotations.Experimental;
import org.apache.beam.sdk.annotations.Experimental.Kind;

/**
 * The results of a query for metrics. Allows accessing all of the metrics that matched the filter.
 */
@AutoValue
@Experimental(Kind.METRICS)
public abstract class MetricQueryResults {
  /** Return the metric results for the getCounters that matched the filter. */
  public abstract Iterable<MetricResult<Long>> getCounters();

  /** Return the metric results for the getDistributions that matched the filter. */
  public abstract Iterable<MetricResult<DistributionResult>> getDistributions();

  /** Return the metric results for the getGauges that matched the filter. */
  public abstract Iterable<MetricResult<GaugeResult>> getGauges();

  public static MetricQueryResults create(
      Iterable<MetricResult<Long>> counters,
      Iterable<MetricResult<DistributionResult>> distributions,
      Iterable<MetricResult<GaugeResult>> gauges) {
    return new AutoValue_MetricQueryResults(counters, distributions, gauges);
  }
}
