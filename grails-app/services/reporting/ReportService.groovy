package reporting

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.transaction.Transactional
import org.springframework.security.core.context.SecurityContextHolder

class ReportService {

    def list(params) {
        def results
        def username = SecurityContextHolder.getContext().getAuthentication().getName()
        if (SpringSecurityUtils.ifAllGranted('ROLE_ADMINY')) {
            results = Report.list(params).toList()
        }
        else {
            results = Report.where {
                eq ("user",username )
            }.list(params)
        }
        return results
    }

    def countrRports() {
        def count
        def username = SecurityContextHolder.getContext().getAuthentication().getName()
        if (SpringSecurityUtils.ifAllGranted('ROLE_ADMINY')) {
            count = Report.count()
        }
        else {
            count = Report.where {
                eq ("user",username )
            }.count()
        }
        return count
    }

    def save(Report reportInstance) {
    // Add current User
        reportInstance.setUser(SecurityContextHolder.getContext().getAuthentication().getName())
        reportInstance.save flush:true, failOnError: true

    }

    def delete(Report reportInstance) {

        reportInstance.delete flush:true

    }

}
