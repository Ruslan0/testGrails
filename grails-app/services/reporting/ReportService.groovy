package reporting

import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.core.context.SecurityContextHolder

class ReportService {

    def list(params) {
        def results
        def login = SecurityContextHolder.getContext().getAuthentication().getName()
        if (SpringSecurityUtils.ifAllGranted('ROLE_ADMINY')) {
            results = Report.list(params).toList()
        } else {
            results = Report.where {
                eq("login", login)
            }.list(params)
        }
        return results
    }

    def countrReports() {
        def count
        def login = SecurityContextHolder.getContext().getAuthentication().getName()
        if (SpringSecurityUtils.ifAllGranted('ROLE_ADMINY')) {
            count = Report.count()
        } else {
            count = Report.where {
                eq("login", login)
            }.count()
        }
        return count
    }

    def save(Report reportInstance) {
        // Add current User
        reportInstance.setLogin(SecurityContextHolder.getContext().getAuthentication().getName())
        def a = Employer.list().find{it.name=SecurityContextHolder.getContext().getAuthentication().getName()}
        reportInstance.employer=[a]
        reportInstance.save flush: true, failOnError: true
    }

    def delete(Report reportInstance) {

        reportInstance.delete flush: true

    }

}
