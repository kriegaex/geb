ruleset {
	/*ruleset('rulesets/basic.xml')
	ruleset('rulesets/braces.xml')
	ruleset('rulesets/concurrency.xml')
	ruleset('rulesets/convention.xml')
	ruleset('rulesets/design.xml')
	ruleset('rulesets/dry.xml')
	ruleset('rulesets/exceptions.xml')
	ruleset('rulesets/formatting.xml') {
		ClassJavadoc {
			enabled = false
		}
		SpaceAroundMapEntryColon {
			characterAfterColonRegex = /\s/
		}
		FileEndsWithoutNewline {
			enabled = false
		}
		LineLength {
			length = 200
		}
	}
	ruleset('rulesets/generic.xml')
	ruleset('rulesets/groovyism.xml')*/
	ruleset('rulesets/imports.xml') {
		MisorderedStaticImports {
			comesBefore = false
		}
		NoWildcardImports {
			enabled = false
		}
		UnnecessaryGroovyImport {
			doNotApplyToFileNames = 'ExceptionToPngConverter.groovy'
		}
	}
	/*ruleset('rulesets/junit.xml')
	ruleset('rulesets/logging.xml')
	ruleset('rulesets/naming.xml')
	ruleset('rulesets/security.xml')
	ruleset('rulesets/serialization.xml')
	ruleset('rulesets/size.xml') {
		CrapMetric {
			enabled = false
		}
	}
	ruleset('rulesets/unnecessary.xml')
	ruleset('rulesets/unused.xml')*/
}