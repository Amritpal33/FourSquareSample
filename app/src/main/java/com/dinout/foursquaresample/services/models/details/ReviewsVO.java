package com.dinout.foursquaresample.services.models.details;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 08/02/16.
 */
public class ReviewsVO
{
    ArrayList<ReviewGroups> groups;

    public ArrayList<ReviewGroups> getGroups()
    {
        return groups;
    }

    public static class ReviewGroups
    {
        ArrayList<ReviewItems> items;

        public ArrayList<ReviewItems> getItems()
        {
            return items;
        }

        public static class ReviewItems
        {
            private Long createdAt;
            private String text;
            private User user;

            public Long getCreatedAt()
            {
                return createdAt;
            }

            public String getText()
            {
                return text;
            }

            public User getUser()
            {
                return user;
            }

            public static class User
            {
                private String firstName;
                private String lastName;
                private UserPhoto photo;

                public String getFirstName()
                {
                    return firstName;
                }

                public void setLastName(String lastName)
                {
                    this.lastName = lastName;
                }

                public UserPhoto getPhoto()
                {
                    return photo;
                }

                public String getUserName()
                {
                    return String.format("%s %s", firstName, lastName);
                }

                public static class UserPhoto
                {
                    private String prefix;
                    private String suffix;

                    public String getUserPhotoUrl()
                    {
                        return String.format("%s110x110%s", prefix, suffix);
                    }

                }
            }

        }
    }
}
