def call(Map config=[:], Closure body) {
   
    node {

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
