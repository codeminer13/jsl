@Library('pipleline-library-demo')_


pipeline {
    agent any

    tools {
        nodejs 'node'
    }
    
    buildJavascriptApp deploy: false, {
        notify type: "slack", message: "Build succeeded"
    }
}

