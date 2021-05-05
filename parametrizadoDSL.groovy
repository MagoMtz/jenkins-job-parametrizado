job('ejemplo2-job-dsl') {
  description('Job DSL de ejmplo para el curso de Jenkiuns')
    
  scm {
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node -> 
      node / gitConfigName('MagoMtz')      
      node / gitConfigEmail('magomtz94@gmail.com')	
    }	
  }
  
  parameters {
    stringParam('nombre', defaultValue = 'Mago', description = 'Parametro de cadena para el nombre')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
  
  
  triggers {
    cron('H/7 * * * *')
  }
  
  steps {
  	shell("bash jobscript.sh")
  }
  
  publishers {
  	mailer('magomtz94@gmail.com', true, true)
    slackNotifier {
      notifyAborted(true)
      notifyEveryFailure(true)
      notifyNotBuilt(false)
      notifyUnstable(false)
      notifyBackToNormal(true)
      notifySuccess(false)
      notifyRepeatedFailure(false)
      startNotification(false)
      includeTestSummary(false)
      includeCustomMessage(false)
      customMessage(null)
      sendAs(null)
      commitInfoChoice('NONE')
      teamDomain(null)
      authToken(null)
    }
  }
  
  
}
