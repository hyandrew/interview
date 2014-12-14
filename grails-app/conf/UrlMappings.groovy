class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/" (controller:"blogEntryDTO", action:"index")
		"500"(view:'/error')
		
        //"/"(view:"/index")
        //"500"(view:'/error')
	}
}
