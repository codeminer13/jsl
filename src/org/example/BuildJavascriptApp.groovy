package org.example

class BuildJavascriptApp {
    def exec(Map config=[:], Closure body={}) {
        node {
            git url: "https://github.com/navaryan13/ytpub"

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
}
