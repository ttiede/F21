<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>  

<%@attribute name="id" required="true"%>
<%@attribute name="value" required="false"%>
<input type="text" id="${id}" name="${id}" vale="${value}" date-format="DD/MM/YYYY"/>
<p> ${value}</p>
<script type="text/javascript">
	$('#${id}').datetimepicker({
		format : 'DD/MM/YYYY'
	});
</script>