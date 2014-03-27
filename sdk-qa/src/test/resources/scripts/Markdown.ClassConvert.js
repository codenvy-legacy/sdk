

function convertMd() {
	var converter = new Markdown.Converter();
	$.each($('.md'),
			function(key, value) {
				$(value).html(
						converter.makeHtml($(value).html()
								.replace(/&gt;/g, '>')));
			});
}

window.onload = convertMd;