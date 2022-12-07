def call(Map config=[:], Closure body={}) {
   
    node {
        env.NODEJS_HOME = "${tool 'node'}"
        env.PATH = "${env.NODEJS_HOME}/bin:${env.PATH}"

        git url: "https://github.com/navaryan13/sample-nodejs"
        stage("Install") {
            sh "npm install"
        }
        stage("Test") {
            sh "npm test"
        }
        /*stage("Build") {
            sh "npm run build"
        }
        stage("Deploy") {
            if (config.deploy) {
                sh "npm publish"
            }
        } */
        stage('SonarQube Analysis') {
            def scannerHome = tool 'sonscan';
            withSonarQubeEnv(installationName: 'sq1') {
                sh "${scannerHome}/bin/sonar-scanner"
            }
        }
        body()
    }
}
