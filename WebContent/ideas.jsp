<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ideas.css">
<script type="text/javascript" src="login.js"> </script>
<div class="container auth">
    <div id="big-form" class="well auth-box">
      <form name = "myform2" method="post" action="ideas">
        <fieldset>

          <!-- Form Name -->
          <legend>Ajouter une idée</legend>


          <!-- Text input-->
          <div class="form-group">
            <label class=" control-label" for="textinput">Title</label>  
            <div class="">
              <input id="textinput" name="title" placeholder="Title" class="form-control input-md" type="text">
            </div>
          </div>

          <!-- Password input-->
          <div class="form-group">
            <label class=" control-label" for="passwordinput">Comment-ids</label>
            <div class="">
              <input id="passwordinput" name="commentIds" placeholder="Comment-ids" class="form-control input-md" type="password">
            </div>
          </div>
          
                    <!-- Password input-->
          <div class="form-group">
            <label class=" control-label" for="passwordinput">Scientist-id</label>
            <div class="">
              <input id="passwordinput" name="scientistId" placeholder="Scientist-id" class="form-control input-md" type="password">
            </div>
          </div>
          
                    <!-- Password input-->
          <div class="form-group">
            <label class=" control-label" for="passwordinput">Domain-ids</label>
            <div class="">
              <input id="passwordinput" name="domainIds" placeholder="Domain-ids" class="form-control input-md" type="password">
            </div>
          </div>

          <!-- Textarea -->
          <div class="form-group">
            <label class=" control-label" for="textarea">Content</label>
            <div class="">                     
              <textarea class="form-control" id="textarea" name="content">contenu par défaut</textarea>
            </div>
          </div>
		  
		  <input type="submit" value="ajouter idée">
        </fieldset>
      </form>
    </div>
    <div class="clearfix"></div>
  </div>