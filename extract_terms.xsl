<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
	
<xsl:output method="text" indent="no"/>

<xsl:template match="section">
	<xsl:apply-templates select="descendant::term"/>
</xsl:template>

<xsl:template match="term">
	<xsl:value-of select="text()"/><xsl:text>
</xsl:text>
</xsl:template>
</xsl:stylesheet>
