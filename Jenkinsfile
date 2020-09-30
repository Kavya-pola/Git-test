pipeline{
 agent any
 stages{
  stage("clean"){
   steps{
    script{
     mvn clean test
    }
   }
  }
  stage("build"){
    steps{
      bat 'mvn --batch-mode compile'
    }
  }
  stage("test"){
    steps{
      bat 'mvn --batch-mode resources:testResources compiler:testCompile surefire:test'
  }
  }
 }
}
