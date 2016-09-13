package org.apache.spark.ml.spark.models.gm;

import hex.ClusteringModel;
import org.apache.spark.util.Utils;

public class GaussianMixtureParameters extends ClusteringModel.ClusteringParameters {
    @Override
    public String algoName() {
        return "GaussianMixture";
    }

    @Override
    public String fullName() {
        return "Gaussian Mixture(*Spark*)";
    }

    @Override
    public String javaName() {
        return GaussianMixtureModel.class.getName();
    }

    @Override
    public long progressUnits() { return _max_iterations; }

    public int _max_iterations = 100;
    public double _convergence_tolerance = 0.01;
    public long _seed = Utils.random().nextLong();
    public boolean _standardize = true;

    public void validate(GaussianMixture gm) {
        if (_max_iterations < 0 || _max_iterations > 1e6) {
            gm.error("_max_iterations", " max_iterations must be between 0 and 1e6");
        }
    }

}
