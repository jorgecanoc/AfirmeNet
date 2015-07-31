<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style>
.ui-progressbar {
	position: relative;
}

.progress-label {
	position: absolute;
	left: 50%;
	top: 4px;
	font-weight: bold;
	text-shadow: 1px 1px 0 #fff;
}
</style>
<body>
	<form id="dispatcher" name="dispatcher" method="POST"
		action="${context}/test/dispatcher.htm">
		<input type="hidden" name="nextAction" id="nextAction"
			value="${nextAction}">
	</form>
	<div id="progressbar">
		<div class="progress-label">Loading...</div>
	</div>
</body>
<script>
	$(function() {
		var progressbar = $("#progressbar"), progressLabel = $(".progress-label");

		progressbar.progressbar({
			value : false,
			change : function() {
				progressLabel.text(progressbar.progressbar("value") + "%");
			},
			complete : function() {
				progressLabel.text("Complete!");
				document.getElementById("dispatcher").submit();
			}
		});

		function progress() {
			var val = progressbar.progressbar("value") || 0;

			progressbar.progressbar("value", val + 5);

			if (val < 99) {
				setTimeout(progress, 80);
			}
		}

		setTimeout(progress, 1000);
	});

</script>
</html>

