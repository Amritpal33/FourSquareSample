package com.dinout.foursquaresample.services.models.details;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class CategoriesVO
{
    private String id;
    private String name;
    private String pluralName;
    private String shortName;
    private boolean primary;
    private Icon icon;

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPluralName()
    {
        return pluralName;
    }

    public String getShortName()
    {
        return shortName;
    }

    public boolean isPrimary()
    {
        return primary;
    }

    public Icon getIcon()
    {
        return icon;
    }

    private static class Icon
    {
        private String prefix;
        private String suffix;

        public String getPrefix()
        {
            return prefix;
        }

        public String getSuffix()
        {
            return suffix;
        }
    }
}
