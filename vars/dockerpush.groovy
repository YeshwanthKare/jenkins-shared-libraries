def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(
      credentialsId:"docker",
      usernameVariable:"dockerHubUser", 
      passwordVariable:"dockerHubPass")]){
  sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
  sh "docker image tag node-app:latest ${env.dockerHubUser}/node-app:latest"
  sh "docker push ${env.dockerHubUser}/node-app:latest"
  }
}
