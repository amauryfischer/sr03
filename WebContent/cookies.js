	function writeCookie(name, value, days){
		//By default, there is no expiration so the cookie is temporary var expires = "";
		var expires = "";

		//Specfying a number of days makes the cookie persistent 
		if (days){
			var date = new Date();
			date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
			expires = "; expires =" + date.toGMTString;
		}
		// Set the cookie to the name, value, and expiration date
		document.cookie = name + "=" + value + expires + "; path=/";
		
	}

	function readCookie(name) {
	    var nameEQ = name + "=";
	    var ca = document.cookie.split(';');
	    for(var i=0;i < ca.length;i++) {
	        var c = ca[i];
	        while (c.charAt(0)==' ') c = c.substring(1,c.length);
	        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	    }
	    return null;
	}
	
	
	function eraseCookie(name){
		// Erase the specified cookie
		writeCookie(name, "", -1);
	}