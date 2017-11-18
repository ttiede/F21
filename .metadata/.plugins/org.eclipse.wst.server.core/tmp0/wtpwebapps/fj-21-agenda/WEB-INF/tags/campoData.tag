<%@attribute name="id" required="true"%>
<input type="text" id="${id}" name="${id}" />
<script type="text/javascript">
	$('#${id}').datetimepicker({
		format : 'DD/MM/YYYY'
	});
</script>