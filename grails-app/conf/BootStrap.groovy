import org.reporting.SecUser
import org.reporting.SecRole
import org.reporting.SecUserSecRole
import reporting.Employer

class BootStrap {

    def init = { servletContext ->
        if (Employer.list().empty) {
            Employer admin = new Employer (login: 'admin', password: 'secret')
            Employer simpleuser = new Employer (login: 'user', password: '123456')
            Employer.saveAll([admin,simpleuser])
        }
        Employer.list().each {
            SecUser user = new SecUser(username: it.login, password: it.password, enabled:true).save()
            String rolename
            if (it.login=='admin')
                rolename = 'ROLE_ADMINY'
            else
                rolename = 'ROLE_COMMON'
            SecRole role = new SecRole(authority: rolename).save()
            SecUserSecRole.create(user, role)
        }
    }
    def destroy = {
    }
}
