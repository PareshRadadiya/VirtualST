/*
 * MoonCake v1.1 - Template JS
 *
 * This file is part of MoonCake, an Admin template build for sale at ThemeForest.
 * For questions, suggestions or support request, please mail me at maimairel@yahoo.com
 *
 * Development Started:
 * July 28, 2012
 * Last Update:
 * October 10, 2012
 *
 */

;(function( $, window, document, undefined ) {
	
	var Customizer = function( ) {
		this.init();
	}

	Customizer.prototype = {

		patterns: [
			'../theme_assets/assets/images/layout/bg/arches.png', 
			'../theme_assets/assets/images/layout/bg/blu_stripes.png', 
			'../theme_assets/assets/images/layout/bg/bright_squares.png', 
			'../theme_assets/assets/images/layout/bg/brushed_alu.png', 
			'../theme_assets/assets/images/layout/bg/circles.png', 
			'../theme_assets/assets/images/layout/bg/climpek.png', 
			'../theme_assets/assets/images/layout/bg/connect.png', 
			'../theme_assets/assets/images/layout/bg/corrugation.png', 
			'../theme_assets/assets/images/layout/bg/cubes.png', 
			'../theme_assets/assets/images/layout/bg/diagonal-noise.png', 
			'../theme_assets/assets/images/layout/bg/diagonal_striped_brick.png', 
			'../theme_assets/assets/images/layout/bg/diamonds.png', 
			'../theme_assets/assets/images/layout/bg/diamond_upholstery.png', 
			'../theme_assets/assets/images/layout/bg/escheresque.png', 
			'../theme_assets/assets/images/layout/bg/fabric_plaid.png', 
			'../theme_assets/assets/images/layout/bg/furley_bg.png', 
			'../theme_assets/assets/images/layout/bg/gplaypattern.png', 
			'../theme_assets/assets/images/layout/bg/gradient_squares.png', 
			'../theme_assets/assets/images/layout/bg/grey.png', 
			'../theme_assets/assets/images/layout/bg/grilled.png', 
			'../theme_assets/assets/images/layout/bg/hexellence.png', 
			'../theme_assets/assets/images/layout/bg/lghtmesh.png', 
			'../theme_assets/assets/images/layout/bg/light_alu.png', 
			'../theme_assets/assets/images/layout/bg/light_checkered_tiles.png', 
			'../theme_assets/assets/images/layout/bg/light_honeycomb.png', 
			'../theme_assets/assets/images/layout/bg/littleknobs.png', 
			'../theme_assets/assets/images/layout/bg/nistri.png', 
			'../theme_assets/assets/images/layout/bg/noise_lines.png', 
			'../theme_assets/assets/images/layout/bg/noise_pattern_with_crosslines.png', 
			'../theme_assets/assets/images/layout/bg/noisy_grid.png', 
			'../theme_assets/assets/images/layout/bg/norwegian_rose.png', 
			'../theme_assets/assets/images/layout/bg/pineapplecut.png', 
			'../theme_assets/assets/images/layout/bg/pinstripe.png', 
			'../theme_assets/assets/images/layout/bg/project_papper.png', 
			'../theme_assets/assets/images/layout/bg/ravenna.png', 
			'../theme_assets/assets/images/layout/bg/reticular_tissue.png', 
			'../theme_assets/assets/images/layout/bg/retina_wood.png', 
			'../theme_assets/assets/images/layout/bg/rockywall.png', 
			'../theme_assets/assets/images/layout/bg/roughcloth.png', 
			'../theme_assets/assets/images/layout/bg/shattered.png', 
			'../theme_assets/assets/images/layout/bg/silver_scales.png', 
			'../theme_assets/assets/images/layout/bg/skelatal_weave.png', 
			'../theme_assets/assets/images/layout/bg/small-crackle-bright.png', 
			'../theme_assets/assets/images/layout/bg/small_tiles.png', 
			'../theme_assets/assets/images/layout/bg/square_bg.png', 
			'../theme_assets/assets/images/layout/bg/struckaxiom.png', 
			'../theme_assets/assets/images/layout/bg/subtle_stripes.png', 
			'../theme_assets/assets/images/layout/bg/vichy.png', 
			'../theme_assets/assets/images/layout/bg/washi.png', 
			'../theme_assets/assets/images/layout/bg/wavecut.png', 
			'../theme_assets/assets/images/layout/bg/weave.png', 
			'../theme_assets/assets/images/layout/bg/whitey.png', 
			'../theme_assets/assets/images/layout/bg/wood_pattern.png', 
			'../theme_assets/assets/images/layout/bg/white_brick_wall.png', 
			'../theme_assets/assets/images/layout/bg/white_tiles.png', 
			'../theme_assets/assets/images/layout/bg/worn_dots.png'
		], 
		invalidPatterns: [], 

		init: function( ) {
			var customizer = $( '#customizer', 'body' ), self = this;

			if( customizer && customizer.length ) {

				// Generate Pattern List
				var patternList = $( '<div id="pattern-list" class="clearfix"><ul></ul></div>' ).appendTo( customizer );

				customizer.find( '#showButton' ).on( 'click', $.proxy(function(e) { 
					customizer.animate({ left: customizer.css('left') === '0px'? '-236px' : 0 }, 'slow');

					if( !patternList.hasClass( 'patterns-loaded' ) ) {
						this.preloadPatterns(function() {
							$.each(this.patterns, function(i, p) {
								if( $.inArray( p, self.invalidPatterns) == -1 ) {
									$( 'ul', patternList).append( $('<li></li>').css( 'backgroundImage', 'url(' + p + ')' ) );
								}
							});
							patternList
								.addClass( 'patterns-loaded' )
								.on( 'click', 'li', function() {
									$('body').css( 'backgroundImage', $(this).css( 'backgroundImage' ) );
								});
						});
					}
				}, this));

				// Init Layout Changer
				customizer.find( 'input:checkbox[name="layout-mode"]' )
					.on( 'change', function() {
						$( '#wrapper' ).toggleClass( 'full', !$(this).attr('checked') );
					})
					.prop('checked', !$('#wrapper').hasClass('full'))
					.trigger('change');
			}
		}, 

		preloadPatterns: function( callback ) {
			var toLoad = this.patterns.length, 
				self = this;
			$.each(this.patterns, function(i, p) {
				var img = $( '<img />' ).load( function() {
					toLoad--;
					toLoad <= 0 && callback.call( self );
				}).error(function() {
					toLoad--;
					self.invalidPatterns.push(p);
				});

				img[0].src = p;
			});
		}
	};

	$( document ).ready( function( ) {
		new Customizer();
	});

	
}) (jQuery, window, document);