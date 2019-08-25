### build the repositorycd
cd client-service
mvn clean install
cd ../travel-agency-service
mvn clean install
cd ..
 
### set docker env
eval $(minikube docker-env)
kubectl create clusterrolebinding admin --clusterrole=cluster-admin --serviceaccount=default:default
 
### build the docker images on minikube
cd travel-agency-service
docker build -t travel-agency-service .
cd ../client-service
docker build -t client-service .
cd ..

#Enable Ingress Addons
minikube addons enable ingress

### travel-agency-service
kubectl delete -f travel-agency-service/travel-agency-deployment.yaml
kubectl create -f travel-agency-service/travel-agency-deployment.yaml
 
### client-service
kubectl delete configmap client-config.yaml
kubectl delete -f client-service/client-config-deployment.yaml
 
kubectl create -f client-service/client-config.yaml
kubectl create -f client-service/client-config-deployment.yaml

kubectl delete -f gateway-service/gateway-service-deployment.yaml
kubectl create -f gateway-service/gateway-service-deployment.yaml
 
# Check that the pods are running
kubectl get pods
minikube service client-service