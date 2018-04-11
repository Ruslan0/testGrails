class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/" {
            controller = "Report"
            action = "index"
        }
        "/api"(controller: "ReportJsonApi", action: "index")
        "/api/$id?"(controller: "ReportJsonApi", action: "show")
        "/api/new" (controller: "ReportJsonApi", action: "newrec", parseRequest: true)
        "/api/update" (controller: "ReportJsonApi", action: "update", parseRequest: true)
        //        "/blog/$id"(controller:"Report")
//        "/"(view:"/index")
        "500"(view:'/error')
	}
}
