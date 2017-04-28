<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ideas.css">
<script type="text/javascript" src="login.js"> </script>
<div class="container auth">
    <div id="big-form" class="well auth-box">
      <form name = "myform2" method="post" action="comments">
        <fieldset>

          <!-- Form Name -->
          <legend>Ajouter un commentaire</legend>

          <!-- Password input-->
          <div class="form-group">
            <label class=" control-label" for="passwordinput">Scientist-id</label>
            <div class="">
              <input id="passwordinput" name="scientistId" placeholder="Comment-ids" class="form-control input-md" type="password">
            </div>
          </div>
          
                    <!-- Password input-->
          <div class="form-group">
            <label class=" control-label" for="passwordinput">Idea-id</label>
            <div class="">
              <input id="passwordinput" name="ideaId" placeholder="Scientist-id" class="form-control input-md" type="password">
            </div>
          </div>

          <!-- Textarea -->
          <div class="form-group">
            <label class=" control-label" for="textarea">Content</label>
            <div class="">                     
              <textarea class="form-control" id="textarea" name="content">contenu par défaut</textarea>
            </div>
          </div>
		  
		  <input type="submit" value="ajouter mon commentaire">
        </fieldset>
      </form>
    </div>
    <div class="clearfix"></div>
  </div>

</body>
</html>
