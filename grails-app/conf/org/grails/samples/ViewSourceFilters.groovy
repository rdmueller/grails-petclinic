package org.grails.samples

class ViewSourceFilters {
	def grailsApplication

	def filters = {
		all(controller:'*', action:'*') {
			before = {

			}
			after = { Map model ->
				model = model?:[:]
				def controllerClass = grailsApplication.getArtefactByLogicalPropertyName("Controller", controllerName)
				model["controllerClass"] = controllerClass.clazz.name
				model["viewPath"] = "$controllerName:${model['viewName'] ?: actionName}"
			}
			afterView = { Exception e ->

			}
		}
	}
}
