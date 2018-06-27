pipeline {
  //Donde se va a ejecutar el Pipeline  
  agent {    label 'Slave_Induccion'  } 
 
 options {
 //Mantener artefactos y salida de consola para el # específico de ejecucionesrecientes del Pipeline.
 buildDiscarder(logRotator(numToKeepStr: '3'))
 //No permitir ejecuciones concurrentes de Pipeline
 disableConcurrentBuilds()  
 
 }
 
  //Una sección que define las herramientas para “autoinstalar” y poner en la PATH 
  tools {  
  jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master    gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master 
  }
  //Aquí comienzan los “items” del Pipeline 
  stages{   
stage('Checkout'){
steps{
echo "------------>Checkout<------------"
checkout(
[
$class: 'GitSCM', branches: [[name: '*/master']],
doGenerateSubmoduleConfigurations: false,
 extensions: [],
 gitTool:'Git_Centos', submoduleCfg: [],
 userRemoteConfigs: [[credentialsId:'GitHub_manu9010',
 url:'https://github.com/manu9010/ceiba-estacionamiento']]
 ]
 )
 }
 }
  stage('Unit Tests') {
  
  steps{  
  echo "------------>Unit Tests<------------"     
 sh './gradlew test'
  }   
  }    
  stage('Integration Tests') {      
  steps {      
  echo "------------>Integration Tests<------------"      
 sh './gradlew integrationTest'
  }  
  }    
  stage('Static Code Analysis') {   
  steps{     
echo '------------>Análisis de código estático<------------'
 withSonarQubeEnv(​'SonarQube server 7.1.0'​) { 

 sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties" 

 }

 }  
 }    
 
 stage('Build') {     
 steps {        
 echo "------------>Build<------------"
 }   
 } 
 } 
 post {   
 always {     
 echo 'This will always run'    
 }   
 success {      
 echo 'This will run only if successful'    
 }   
 failure {    
 echo 'This will run only if failed' 
 }   
 unstable {     
 echo 'This will run only if the run was marked as unstable'  
 }    
 changed {    
 echo 'This will run only if the state of the Pipeline has changed'   
 echo 'For example, if the Pipeline was previously failing but is now successful'  
 } 
 }
 }