import java.io.File;
import net.sf.javaml.clustering.evaluation.SumOfSquaredErrors;
import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.DistanceMeasure;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;
import net.sf.javaml.clustering.KMedoids;
import net.sf.javaml.clustering.evaluation.AICScore;
import net.sf.javaml.clustering.evaluation.Gamma;
import net.sf.javaml.distance.EuclideanDistance;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.clustering.DensityBasedSpatialClustering;
import net.sf.javaml.clustering.evaluation.CIndex;
import net.sf.javaml.core.Dataset;

import net.sf.javaml.clustering.evaluation.AICScore;
import net.sf.javaml.clustering.evaluation.BICScore;


import net.sf.javaml.tools.data.FileHandler;

public class main {

    public static void main(String[] args) {

        //data file linking with 4 clusters
        Dataset data = FileHandler.loadDataset(new File("iris.data"), 4, ",");

    //the three algorithms we will be comparing, with Kmeans
        Clusterer KmeansCLustering = new KMeans();
        Clusterer DensityClustering = new DensityBasedSpatialClustering();
        Clusterer KmedoidsClustering = new KMedoids();

        //creating the KmeansCluster
        Dataset[] KmeansClustering = kmeans.cluster(data);

        //getting the AIC score for KMeans with function AIScore
        ClusterCheck ClusterAICScore = new AICScore(); //Euclidean distance for AIC scoring
        //getting the BIC score for KMeans with function AIScore
        ClusterCheck BICSCore = new BICScore();
        //getting the ED  KMeans with function below
        EDCalc euc = new EuclideanDistance();
        //getting the cindex score for KMeans with function CIndex
        ClusterCheck Cindex = new CIndex();
        //getting the sumError  for Kmeans with function
        ClusterCheck SumSquaredError = new SumOfSquaredErrors();
        //getting the gamma score  for Kmeans Clustering with function gamma
        ClusterCheck gamma = new Gamma();


        // Printing the scores for Kmeans clustering algorithm

        double KmeansAICScore = ClusterAICScore.score(KmeansClustering);
        double kmeansCIndexScore = Cindex.score(KmeansClustering);
        double KmeansBIC = BICSCore.score(KmeansClustering);
        double GammaScoreKmeans = gamma.score(KmeansClustering);

        System.out.println("The KMeans AIC is: " + KmeansAICScore);
        System.out.println("The KMeans CINDEX is: " + kmeansCIndexScore);
        System.out.println("The KMeans BIC is: " + KmeansBIC);
        System.out.println("The KMeans Gamma is: " + GammaScoreKmeans);
        System.out.println("Sum of Squared Error for Kmeans is " + SumSquaredError);

        printClusterAlgorithm(KmeansClustering); //print the output of KMEANS cluster


        //for Density based Clustering creating the DB cluster
        Dataset[] DensityBasedCluster = dbscan.cluster(data);

        ClusterCheck DensityClusterAICScore = new AICScore(); //Euclidean distance for AIC scoring

        ClusterCheck DensityBICSCore = new BICScore();

        EDCalc Densityeuc = new EuclideanDistance();
        //get the gamma score with gamma()function for KMedoids
        ClusterCheck DensityCindex = new CIndex();

        ClusterCheck DensitySumSquaredError = new SumOfSquaredErrors();
        //get the gamma score with gamma()function for density
        ClusterCheck Densitygamma = new Gamma();

        double DensityAICScore = DensityClusterAICScore.score(DensityBasedCluster);
        double DensityCIndexScore = DensityCindex.score(DensityBasedCluster);
        double DensityBIC = DensityBICSCore.score(DensityBasedCluster);
        double DensityGamma = Densitygamma.score(DensityBasedCluster);

        System.out.println("The Density Based Cluster AIC is: " + DensityAICScore);
        System.out.println("The Density Based Cluster Cindex is: " + DensityCIndexScore);
        System.out.println("The Density Based Cluster BIC is: " + DensityBIC);
        System.out.println("The Density Based Cluster Gamma is: " + DensityGamma);

        printClusterAlgorithm(DensityBasedCluster); //print the output of Density cluster

        //for KMedoids clustering scores
        //create the Kmedoids cluster dataset
        Dataset[] KMedoidsCluster = kmdoids.cluster(data);

        //get the aic score with aic function for KMedoids
        ClusterCheck KMClusterAICScore = new AICScore(); //Euclidean distance for AIC scoring
        //get the aic score with BICScore function for KMedoids
        ClusterCheck KMBICSCore = new BICScore();
        //get the BIC score with BICscore() function for KMedoids
        //getting the ED  for KMedoids with function
        EDCalc KMeuc = new EuclideanDistance();

        //get the cindex score with CIndex function for KMedoids
        ClusterCheck KMCindex = new CIndex();

        //get the sumerror() using the function for KMedoids
        ClusterCheck KMSumSquaredError = new SumOfSquaredErrors();

        //get the gamma score with gamma()function for KMedoids
        ClusterCheck KMgamma = new Gamma();

        //use double as variable for KMdedoids due to decimal scoring
        double KmedoidsAICScore = KMClusterAICScore.score(KMedoidsCluster);
        double KMCIndexScore = KMCindex.score(KMedoidsCluster);
        double KMBIC = KMBICSCore.score(KMedoidsCluster);
        double GammaScoreKM = KMgamma.score(KMedoidsCluster);

        //print all the scores of the Kmedoids clustering
        System.out.println("The Density Based Cluster AIC is: " + KmedoidsAICScore);
        System.out.println("The Density Based Cluster Cindex is: " + KMCIndexScore);
        System.out.println("The Density Based Cluster BIC is: " + KMBIC);
        System.out.println("The Density Based Cluster Gamma is: " + GammaScoreKM);

        printClusterAlgorithm(KMedoidsCluster); //print the output of Kmedoids cluster


        //printing the clusters when the cluster algorithm calls it
        //kmeans cluster first gets printed
        private static void printClusterAlgorithm (Dataset[] CA){

            int counter = 0; //initialize a counter
            System.out.println("Printing Cluster Algorithm");
            //cluster output should be 1 plus the counter section
            for (int counter; counter < CA.length; counter++) {
                System.out.println("Cluster Output: " + (counter + 1) + ";");
            //print each instance of the cluster counter
                for (Instance instanceCA : CA[counter]) {
                    System.out.println(instanceCA);

                }

            }

            System.out.println("Cluster Output Done");
        }


    }
}












