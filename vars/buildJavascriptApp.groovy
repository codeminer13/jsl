def call(Map config=[:], Closure body) {
   
    node {
        env.NODEJS_HOME = "${tool 'node'}"
        env.PATH = "${env.NODEJS_HOME}/bin:${env.PATH}"

        git url: "https://github.com/werne2j/sample-nodejs.git"
        stage("Install") {
            sh "npm install"
        }
        stage("Test") {
            sh "npm test"
        }
        stage("Deploy") {
            if (config.deploy) {
                sh "npm publish"
            }
        }
        body()
    }
}
