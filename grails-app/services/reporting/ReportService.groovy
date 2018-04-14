package reporting

import grails.plugin.springsecurity.SpringSecurityUtils
import org.grails.databinding.DataBinder
import org.springframework.security.core.context.SecurityContextHolder

class ReportService {

    def dataBinder


    def list(params) {
        def results
        def login = SecurityContextHolder.getContext().getAuthentication().getName()
        if (SpringSecurityUtils.ifAllGranted('ROLE_ADMINY')) {
            results = Report.list(params).toList()
        } else {
            results = Report.withCriteria {
                employer {
                    eq 'login', login
                }
            }
        }
        return results
    }

    def countrReports() {
        def count
        def login = SecurityContextHolder.getContext().getAuthentication().getName()
        if (SpringSecurityUtils.ifAllGranted('ROLE_ADMINY')) {
            count = Report.count()
        } else {
            count = Report.withCriteria {
                employer {
                    eq 'login', login
                }
            }.size()
        }
        return count
    }

    def save(Report reportInstance) {
        // Add current User
//        DataBinder.bindData(reportInstance,reportInstance)
        def login =SecurityContextHolder.getContext().getAuthentication().getName()
        def a = Employer.list().find{it.login==SecurityContextHolder.getContext().getAuthentication().getName()}
        reportInstance.addToEmployer(a)
        reportInstance.save flush: true, failOnError: true
    }

    def delete(Report reportInstance) {
        reportInstance.delete flush: true
    }

}
