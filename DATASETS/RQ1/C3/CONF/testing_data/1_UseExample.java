// Example of use
// Views affected. Background & 'horizontal phone image'
// You can watch this video with the result https://www.youtube.com/watch?v=3fp5Bdk29OQ&feature=youtu.be

 ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer()
                .addViewToParallax(new ParallaxTransformInformation(R.id.img_background, 2, 2))
                .addViewToParallax(new ParallaxTransformInformation(R.id.tutorial_img_phone, -0.65f,
                        PARALLAX_EFFECT_DEFAULT));
  mViewPager.setPageTransformer(true, pageTransformer);